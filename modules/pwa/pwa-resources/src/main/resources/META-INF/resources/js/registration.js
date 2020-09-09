$(function() {
	const urlB64ToUint8Array = base64String => {
		const padding = '='.repeat((4 - (base64String.length % 4)) % 4)
		const base64 = (base64String + padding).replace(/\-/g, '+').replace(/_/g, '/')
		const rawData = atob(base64)
		const outputArray = new Uint8Array(rawData.length)
		for (let i = 0; i < rawData.length; ++i) {
			outputArray[i] = rawData.charCodeAt(i)
		}
		return outputArray
	}

	const config = {
		userVisibleOnly: true,
		applicationServerKey: urlB64ToUint8Array(applicationServerKey)
	}

	if ('serviceWorker' in navigator) {
		window.addEventListener('load', function() {
			navigator.serviceWorker.register(
				'/o/liferay-pwa/js/service-worker.js',
				{ scope: '/' }
			).then(
				function(registration) {
					console.log('ServiceWorker registration successful with scope: ', registration.scope);
				}, function(err) {
					console.log('ServiceWorker registration failed: ', err);
				}
			);
		});

		navigator.serviceWorker.ready.then(function(reg) {
			if (!themeDisplay.isSignedIn()) {
				return;
			}

			reg.pushManager.getSubscription().then(function(subscription) {
				if (!subscription) {
					Notification.requestPermission().then(function(permission) {
						if (permission === 'granted') {
							reg.pushManager.subscribe(config).then(function(subscription) {
								const url = '/o/pwa-rest/1.0.0/subscribe?p_auth=' + Liferay.authToken;

								const key = subscription.getKey ? subscription.getKey('p256dh') : '';
								const auth = subscription.getKey ? subscription.getKey('auth') : '';

								fetch(url, {
									method: 'POST',
									mode: 'cors',
									cache: 'no-cache',
									credentials: 'same-origin',
									redirect: 'follow',
									referrerPolicy: 'no-referrer',
									body: JSON.stringify({
										data: {
											endpoint: subscription.endpoint,
											key: btoa(String.fromCharCode.apply(null, new Uint8Array(key))),
											auth: btoa(String.fromCharCode.apply(null, new Uint8Array(auth)))
										}
									})
								});
							});
						}
					});
				}
			});
		});
	}
});