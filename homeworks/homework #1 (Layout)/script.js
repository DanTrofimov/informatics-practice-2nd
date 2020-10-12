const textContent = 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. ' +
    'Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus ' +
    'et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ' +
    'ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis ' +
    'enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In' +
    ' enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis ' +
    'eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper ' +
    'nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat' +
    ' vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,' +
    ' tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean ' +
    'imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. ' +
    'Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem ' +
    'quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit ' +
    'vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus.' +
    ' Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci' +
    ' eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales ' +
    'sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc';

const htmlContent = `                
                <article class="card">
                    <h7>${value}</h7>
                    <p>Some text</p>
                    <div class="card-image-placeholder">image</div>
                </article>
`;

// default theme value
let theme = 'light';
let coloredArea = false;
document.styleSheets[3].disabled = true;

// added functional to the menu button
document.getElementById('nav-button').addEventListener( "click", changeMenuVisibility);
// get color-buttons
themeButtons = document.getElementById('header').children;
themeButtons[0].addEventListener("click", changeAreaBackground);
themeButtons[themeButtons.length - 1].addEventListener("click", changeTheme);

function changeTheme() {
    switch (theme) {
        case "light":
            theme = 'dark';
            break;
        case "dark":
            theme = 'light';
            break;
    }
    switch (theme) {
        case "light":
            document.styleSheets[2].disabled = false;
            document.styleSheets[3].disabled = true;
            break;
        case "dark":
            document.styleSheets[2].disabled = true;
            document.styleSheets[3].disabled = false;
            break;
    }
}

function changeAreaBackground() {
    coloredArea = !coloredArea;
    if (!coloredArea) {
        themeButtons[0].style.backgroundColor = "var(--footer-color)";
        themeButtons[0].parentNode.style.backgroundColor = "var(--header-color)";
    } else {
        themeButtons[0].style.backgroundColor = "var(--header-color)";
        themeButtons[0].parentNode.style.backgroundColor = "var(--footer-color)";
    }
}

// work with content
function addContent(idName) {
    let area = document.getElementById(idName);
    if (area.innerText.length > 100) {
        area.innerText = idName
    } else area.innerText = textContent;
}

function addHTMLContent(idName) {
    let area = document.getElementById(idName);
    area.innerHTML = area.innerHTML + htmlContent
}

// some fixes of CSS's display styles
function checkVisibility() {
    let element = document.getElementById('nav-list');
    if (document.documentElement.clientWidth > 800) {
        element.style.display = 'block'
    } else {
        element.style.display = 'none'
    }
}

function changeMenuVisibility() {
    let element = document.getElementById('nav-list');
    switch (element.style.display) {
        case 'none':
            element.style.display = 'block';
            break;
        case 'block':
            element.style.display = 'none';
            break;
        default:
            element.style.display = 'block';
    }
}

