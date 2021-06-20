// let options = {"oLanguage": {
//         "sLengthMenu": "Отображать _MENU_ записей на страницу",
//         "sZeroRecords": "Совпадений не найдено",
//         "sInfo": "Записи _START_ - _END_ из _TOTAL_ записей",
//         "sInfoFiltered": "(отфильтровано из _TOTAL_ записей)",
//         "sInfoEmpty": "0 записей",
//         "oPaginate": {
//             "sNext": "Следующая",
//             "sPrevious": "Предыдущая"
//         },
//         "sSearch": "Поиск"
//     },
// };

function editUser(id) {
    $.ajax({
        type: "GET",
        url: `/admin/users/${id}`,
        success: function(data) {
            $(".result").html(data);
        }
    });
}

function editRoom(id) {
    $.ajax({
        type: "GET",
        url: `/manager/room/${id}`,
        success: function(data) {
            $(".result").html(data);
        }
    })
}

function showUsers() {
    $.ajax({
        type: "GET",
        url: "/admin/users",
        success: function(data) {
            $(".table").html(data);
        }
    })
}

function getRooms() {
    $.ajax({
        type: "GET",
        url: "/manager/rooms",
        success: function(data) {
            if($.fn.DataTable.isDataTable(".table")) {
                $(".table").DataTable().destroy();
                $(".table").html(data);
                $(".table").DataTable({
                    "language": {"url":"//cdn.datatables.net/plug-ins/1.10.25/i18n/Russian.json"}
                }).draw();
            } else {
                $(".table").html(data);
                $(".table").DataTable({
                    "language": {"url":"//cdn.datatables.net/plug-ins/1.10.25/i18n/Russian.json"}
                });
            }
        }
    })
}

$("#saveUser").on("submit", function(event) {
    event.preventDefault();
    $.ajax( {
        type: "POST",
        url: "/admin/user",
        data: $("#saveUser").serializeArray(),
        success: function(data) {
            showUsers();
        },
        error: function(data) {
            alert(data);
        }
    })
})

// $("#saveRoom").on("sumbit", function(event) {
//     event.preventDefault();
//     console.warn("Try to save")
//     $.ajax( {
//         type: "POST",
//         url:"/manager/room",
//         data: $("#saveRoom").serializeArray(),
//         success: function(data) {
//             $(".table").html(data);
//         }
//     })
// })

function saveRoom() {
    $.ajax( {
        type: "POST",
        url:"/manager/room",
        data: $("#saveRoom").serializeArray(),
        success: function(data) {
            console.warn("VAMOSSSSSSSSSSS");
            $(".result").html(data);
        }
    })
}

function getBookings() {
    $.ajax({
        type: "GET",
        url: "/manager/bookings",
        success: function(data) {
            if($.fn.DataTable.isDataTable(".table")) {
                $(".table").DataTable().destroy();
                $(".table").html(data);
                $(".table").DataTable({
                    "language": {"url":"//cdn.datatables.net/plug-ins/1.10.25/i18n/Russian.json"}
                }).draw();
            } else {
                $(".table").html(data);
                $(".table").DataTable({
                    "language": {"url":"//cdn.datatables.net/plug-ins/1.10.25/i18n/Russian.json"}
                });
            }
        }
    })
}

function getTypes() {
    $.ajax({
        type: "GET",
        url: "/manager/types",
        success: function(data) {
            if($.fn.DataTable.isDataTable(".table")) {
                $(".table").DataTable().destroy();
                $(".table").html(data);
                $(".table").DataTable({
                    "language": {"url":"//cdn.datatables.net/plug-ins/1.10.25/i18n/Russian.json"}
                }).draw();
            } else {
                $(".table").html(data);
                $(".table").DataTable({
                    "language": {"url":"//cdn.datatables.net/plug-ins/1.10.25/i18n/Russian.json"}
                });
            }
        }
    })
}

function editType(id) {
    $.ajax ({
        type: "GET",
        url: `/manager/type/${id}`,
        success: function(data) {
            $(".result").html(data);
        }
    })

}

function saveType() {
    $.ajax({
        type: "POST",
        url: "/manager/type",
        data: $("#saveType").serializeArray(),
        success: function(data) {
            $(".result").html(data);
            getTypes();
        }
    })
}
