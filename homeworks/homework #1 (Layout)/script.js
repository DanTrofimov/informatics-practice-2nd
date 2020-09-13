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
                    <h7>Title</h7>
                    <p>Some text</p>
                    <div class="card-image-placeholder">image</div>
                </article>
`;

var showMenu = false;

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

function changeElementVisibility(idName) {
    let element = document.getElementById(idName);
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

    // close navigation after click on nav-item
    for (let i = 0; i < element.children.length; i++) {
        element.children[i].setAttribute('onclick', 'changeElementVisibility(\'nav-list\')')
    }
}