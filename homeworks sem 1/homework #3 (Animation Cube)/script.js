let box = document.getElementById('dvd'),
    translateX = 0;
    translateY = 0;
    boxWidth = box.offsetWidth,
    boxHeight = box.offsetHeight,
    xMin = box.offsetLeft,
    yMin = box.offsetTop,
    xMax = window.innerWidth - xMin - boxWidth - 5,
    yMax = window.innerHeight - yMin - boxHeight - 5,
    requestToAnimate = null,
    direction = 'south-east',
    speed = 6;

init();

function init() {
    requestToAnimate = requestAnimationFrame(init);
    move();
}

function move() {
    setDirection();
    box.style.transform = 'translate3d(' + translateX + 'px, ' + translateY + 'px, 0)';
}

function setDirection() {
    switch (direction) {
        case 'north-east':
            translateX += speed;
            translateY -= speed;
            break;
        case 'north-west':
            translateX -= speed;
            translateY -= speed;
            break;
        case 'south-east':
            translateX += speed;
            translateY += speed;
            break;
        case 'south-west':
            translateX -= speed;
            translateY += speed;
            break;
    }
    checkBounds();
}

function checkBounds() {
    if (translateY <= yMin) {
        if (direction === 'north-west') {
            direction = 'south-west';
        } else if (direction === 'north-east') {
            direction = 'south-east';
        }
    }
    if (translateY >= yMax) {
        if (direction === 'south-east') {
            direction = 'north-east';
        } else if (direction === 'south-west') {
            direction = 'north-west';
        }
    }
    if (translateX <= xMin) {
        if (direction === 'north-west') {
            direction = 'north-east';
        } else if (direction === 'south-west') {
            direction = 'south-east';
        }
    }
    if (translateX >= xMax) {
        if (direction === 'north-east') {
            direction = 'north-west';
        } else if (direction === 'south-east') {
            direction = 'south-west';
        }
    }
}