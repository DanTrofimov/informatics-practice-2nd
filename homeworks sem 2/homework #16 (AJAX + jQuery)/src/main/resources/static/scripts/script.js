const CONTEXT = "http://localhost:8099/";
const USERS_ON_PAGE = 3;
let currentPage = 0;

async function getUsers(){
    await $.ajax({
        url:  `${CONTEXT}/users`,
        type: "GET",
        dataType: "json",
        success: updateTable
    });
    currentPage++;
}

function removeUser(userId){
    $.ajax({
        url:  `${CONTEXT}/users?userId=${userId}`,
        type: "DELETE",
    });

   $(`#row-${userId}`)
        .children('td')
        .animate({
            padding: 0
        })
        .wrapInner('<div />')
        .children()
        .slideUp(function () {
            $(this).closest('tr').remove();
        });

   // animation duration
   setTimeout(() => {updateTable(getUsers())}, 500)
}

function updateTable(users) {
    let table = $("#users-table");
    table.empty();
    let content = users.map(user => getTableRow(user));
    table.append(content);
}

function getTableRow(userData) {
    return `<tr id="row-${userData.id}">
                <td>${userData.name}</td>
                <td>${userData.age}</td>
                <td><button onclick="removeUser(${userData.id})">remove ${userData.id}</button></td>
            </tr>`
}

getUsers();