const CONTEXT = "http://localhost:8099";
const USERS_ON_PAGE = 2;
let currentPage = 0;

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

    setTimeout(() => {
        let currentUsers = getUsersWithPagination(0, USERS_ON_PAGE * currentPage);
        addUsersLayout(currentUsers, "full");
        // animation duration
    }, 500)
}

function getTableRow(userData) {
    return `<tr id="row-${userData.id}">
                <td>${userData.name}</td>
                <td>${userData.age}</td>
                <td><button onclick="removeUser(${userData.id})">remove ${userData.id}</button></td>
            </tr>`
}


function getUsersWithPagination(page = currentPage, usersOnPage = USERS_ON_PAGE) {
    $.ajax({
        url:  `${CONTEXT}/users?usersAmount=${usersOnPage}&offset=${page * usersOnPage}`,
        type: "GET",
        dataType: "json",
        success: addUsersLayout
    });

    currentPage++;
}

function addUsersLayout(users, clear = "full") {
    let table = $("#users-table");
    if (clear === "full") table.empty();
    let content = users.map(user => getTableRow(user));
    table.append(content);
}

getUsersWithPagination();

