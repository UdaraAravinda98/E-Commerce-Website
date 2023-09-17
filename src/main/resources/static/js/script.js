let images = Array.from(document.querySelectorAll('.header img'));
    let currentImageIndex = 0;
    setInterval(function() {
      images[currentImageIndex].classList.remove('active');
      currentImageIndex = (currentImageIndex + 1) % images.length;
      images[currentImageIndex].classList.add('active');
    }, 4000);