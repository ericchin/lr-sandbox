$(function() {
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
	}
});