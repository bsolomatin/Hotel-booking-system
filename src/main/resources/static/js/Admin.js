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

// $("#saveUser").on("submit", function(event) {
//     event.preventDefault();
//     $.ajax( {
//         type: "POST",
//         url: "/admin/user",
//         data: $("#saveUser").serializeArray(),
//         success: function(data) {
//             showUsers();
//         },
//         error: function(data) {
//             alert(data);
//         }
//     })
// })

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
            getRooms();
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

function newType() {
    $.ajax({
        type: "GET",
        url: "/manager/types/add",
        success: function (data) {
            $(".result").html(data);
        }
    })
}

function newRoom() {
    $.ajax({
        type: "GET",
        url: "/manager/rooms/add",
        success: function(data) {
            $(".result").html(data);
        }
    })
}

function deleteRoom(id) {
    $.ajax({
        type: "GET",
        url: `/manager/room/del/${id}`,
        success: function (data) {
            $(".result").html(data);
            getRooms();
        }
    })
}

function saveType() {
    console.warn($("#saveType").serializeArray());
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

function getFeatures() {
    $.ajax({
        type: "GET",
        url: "/manager/features",
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
//fa-3x
function editFeature(id) {
    $.ajax ({
        type: "GET",
        url: `/manager/feature/${id}`,
        success: function(data) {
            $(".result").html(data);
        }
    })
}

function saveFeature() {
    $.ajax({
        type: "POST",
        url: "/manager/feature",
        data: $("#saveFeature").serializeArray(),
        success: function(data) {
                $(".result").html(data);
                getFeatures();
        }
    })
}

function deleteFeature(id) {
    $.ajax({
        type: "GET",
        url: `/manager/feature/del/${id}`,
        success: function(data) {
            $(".result").html(data);
            getFeatures();
        }
    })
}

function getPhotos() {
    $.ajax({
        type: "GET",
        url: "/manager/photos",
        success: function (data) {
            $(".result").html(data);
        }
    })
}

function deleteBooking(id) {
    $.ajax({
        type: "GET",
        url: `/manager/bookings/${id}`,
        success: function(data) {
            $(".result").html(data);
            getBookings();
        }
    })
}

function deleteType(id) {
    $.ajax({
        type: "GET",
        url: `/manager/type/del/${id}`,
        success: function(data) {
            $(".result").html(data);
            getTypes();
        }
    })
}


$("#savePhotos").on("submit", function(event) {
    event.preventDefault();
    alert("Hello!");
    alert($("#savePhotos").serializeArray());
    $.ajax({
        type: "POST",
        url: "/manager/photos",
        data: $("#savePhotos").serializeArray(),
        success: function(data) {
            console.warn(data);
        }
    })
})

// function doBook() {
//     $.ajax({
//         type: "POST",
//         url: "/user/book",
//         data: $("#blockRoom").serializeArray(),
//         success: function (data) {
//
//         }
//     })
// }