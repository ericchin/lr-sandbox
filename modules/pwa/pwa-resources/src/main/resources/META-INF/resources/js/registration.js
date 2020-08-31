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

	const applicationServerKey = '';

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
			reg.pushManager.subscribe(config).then(function(subscription) {
				console.log('KEY:: ' + JSON.stringify(subscription));
				console.log('ENDPOINT:: ' + subscription.endpoint);

				// At this point you would most likely send the subscription
				// endpoint to your server, save it, then use it to send a
				// push message at a later date
			})
		});
	}
});