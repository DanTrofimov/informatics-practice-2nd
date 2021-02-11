let clientMousePosX, clientMousePosY;

// default - two eyes
let eyes = document.getElementsByClassName("eye");
let pupils = document.getElementsByClassName('eye__pupil');
let eyeLeft = eyes[0];
let eyeRight = eyes[1];
let pupilLeft = pupils[0];
let pupilRight = pupils[1];

const eyeRadius = Math.round(parseInt(getComputedStyle(eyeRight).height)/2);
const eyePupilRadius = Math.round(parseInt(getComputedStyle(pupilRight).height)/2);

eyeLeftposX = Math.round(eyeLeft.getBoundingClientRect().x + eyeRadius);
eyeLeftposY = Math.round(eyeLeft.getBoundingClientRect().y + eyeRadius);

eyeRightposX = Math.round(eyeRight.getBoundingClientRect().x + eyeRadius);
eyeRightposY = Math.round(eyeRight.getBoundingClientRect().y + eyeRadius);

window.addEventListener("mousemove", () => {
        clientMousePosX = event.pageX;
        clientMousePosY = event.pageY;
        animatePupil(eyeLeftposX, eyeLeftposY, pupilLeft);
        animatePupil(eyeRightposX, eyeRightposY, pupilRight);

        // checking for new eyes
        if (eyes.length > 2) {
            for (let i = 2; i < eyes.length; i++) {
                animatePupil(Math.round(eyes[i].getBoundingClientRect().x + eyeRadius), Math.round(eyes[i].getBoundingClientRect().y + eyeRadius), eyes[i].childNodes[0]);
            }
        }
    }
);

function animatePupil(eyePosX, eyePosY, pupil) {
    let pupilAngle = Math.atan((clientMousePosX - eyePosX)/(clientMousePosY - eyePosY));
    pupil.style.marginTop = clientMousePosY < eyePosY ? (Math.cos(pupilAngle + Math.PI) * (eyeRadius - eyePupilRadius)) + "px" : (Math.cos(pupilAngle ) * (eyeRadius - eyePupilRadius)) + "px";
    pupil.style.marginLeft = clientMousePosY < eyePosY ? (Math.sin(pupilAngle + Math.PI) * (eyeRadius - eyePupilRadius)) + "px" : (Math.sin(pupilAngle ) * (eyeRadius - eyePupilRadius)) + "px";
}

window.addEventListener("click", addEye);

function addEye() {
    let eye = document.createElement('div');
    eye.className = 'eye';
    eye.innerHTML = '<div class="eye__pupil"></div>';
    eye.style.position = "absolute";
    eye.style.top = clientMousePosY - eyeRadius + "px";
    eye.style.left = clientMousePosX - eyeRadius + "px";
    document.getElementsByClassName('eyes-wrapper')[0].append(eye);
}

