      var current = 0;
        var left = 0;


        var prevButton = document.querySelector('.prev'),
            nextButton = document.querySelector('.next');
        var currentSlide;
        var slides = document.querySelectorAll('.slide');

        currentSlide = slides[current];
        currentSlide.classList.add('top');
        left = -currentSlide.clientWidth;




        nextSlide();
        previousSlide();

        function nextSlide() {

            nextButton.onclick = function(evt) {

                slides.forEach(s => {
                    s.style.zIndex = "1";
                    s.style.right = "0px";
                    s.style.left = "";
                });



                if (current === (slides.length - 1)) current = -1;
                currentSlide = slides[++current];
                currentSlide.style.right = "-" + left + 'px';
                currentSlide.style.zIndex = "2";

                left = -currentSlide.clientWidth;
                runAnimation('right');


            }
        }



        function previousSlide() {
            prevButton.addEventListener('click', function(evt) {
                slides.forEach(s => {
                    s.style.zIndex = "1";
                    s.style.left = "0px";
                    s.style.right = "";
                });
                if (current === 0) current = slides.length;
                currentSlide = slides[--current];
                currentSlide.style.left = "-" + left + 'px';
                currentSlide.style.zIndex = "2";

                left = -currentSlide.clientWidth;
                runAnimation('left');
            });
        }





        function runAnimation(mode) {
            var id = setInterval(f, 5);

            function f() {
                if (left >= -1) {
                    clearInterval(id);
                    left = -currentSlide.clientWidth;
                    if (mode === 'right')
                        currentSlide.style.right = '0px';
                    else
                        currentSlide.style.left = '0px';

                    return;
                } else {
                    left += 10;

                    if (mode === 'right')
                        currentSlide.style.right = left + 'px';
                    else
                        currentSlide.style.left = left + 'px';


                } //else
            }

        } //end func