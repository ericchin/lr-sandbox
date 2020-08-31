self.addEventListener('install', function(e) {
	caches.open('liferay-pwa').then(function(cache) {
		return cache;
	});
});

self.addEventListener('fetch', function(e) {
	e.respondWith(
		caches.open('liferay-pwa').then(function(cache) {
			return cache.match(e.request).then(function (response) {
				return response || fetch(e.request);
			});
		})
	);
});

self.addEventListener('push', function(e) {
	if (e.data) {
		self.registration.showNotification(
			'Liferay PWA',
			{
				body: e.data.text(),
				icon: '/o/liferay-pwa/images/logo.svg'
			}
		);
	}
});