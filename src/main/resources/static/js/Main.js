// document.addEventListener("DOMContentLoaded", function() {
//     sendRequest("GET", `rooms`)
//         .then((data) => showRooms(JSON.parse(data)))
//         .catch((error) => sendRequest("GET", "/error"));
// })

$("#search").on('submit', function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("search"));
    //console.log($("#search").serialize());
    $.ajax({
        processData: false,
        contentType: false,
        type: "POST",
        url: "/search",
        data: formData,
        success: function(data) {
            showRooms(data);
        }
    })
})

function showRooms(data) {
    for (let i = 0; i < data.length; i++) {
        $(".cardBody").append(`
        <div class="col">
            <div class="card text-center" style="width: 18rem">
            <img src = "/images/pexels-max-vakhtbovych-6782567.jpg" class="card-img-top" alt="Hotel room">
                <div class="card-body">
                    <h5 class="card-title">${data[i].roomType.title}</h5>
                    <ul class="list-group list-group-flush">
                        //<li class="list-group-item">Этаж № ${data[i].flat}</li>
                        <li class="list-group-item">Количество комнат: ${data[i].roomType.numberOfRooms}</li>
                        <li class="list-group-item">Цена за сутки, рублей: ${data[i].roomType.price}</li>
                    </ul>
                    <p class="card-text">Кликните по кнопке ниже, чтобы проверить наличие свободных дат</p>
                    <button type="button" id="${data[i].id}" class="btn btn-primary" onclick="modalClick(this)">Бронирование</input>      
                </div>
            </div>
        </div>`);
    }
}

function modalClick(btn) {
    $("#roomId").val(`${btn.id}`);
    sendRequest("GET", `bookings/${btn.id}`)
        .then((data) => createReservationIntervals(JSON.parse(data)))
    $("#exampleModal").modal('toggle');
}

$(".admin.nav-item").click(function () {
    sendRequest("GET", `admin/${$(this).attr("id")}`)
        .then((data) => $.fn.refreshTable(JSON.parse(data)))
        .catch((error) => new Error());
})

$.fn.refreshTable = function (data) {
    $("#table").empty();
    $("#table").append(`<thead><tr id="head"></tr></thead>`);
    $("#table").append(`<tbody id="body"></tbody>`)
    let str = ``;
    $.each(data, function (i, item) {
        str =`<tr>`;
        //$("#body").append('<tr>');
        $.each(item, function (j, itemValue) {
            if (i == 0) {
                $("#head").append($(`<th>${j}</th>`));
            }
            else {
                str+=`<td>${itemValue}</td>`;
                //$("#body").append($(`<td>${itemValue}</td>`))
            }
        })
        str+=`</tr>`;
        $("#body").append(str);
        //$("#body").append("</tr>");
    })
}

$("#blockForm").on('submit', function (e) {
    e.preventDefault();
    let formData = new FormData(document.getElementById("blockForm"));
    console.log(formData.entries());
    $.ajax({
        processData: false,
        contentType: false,
        type: "POST",
        url: "/test",
        data:formData,
        success: function(data) {
            alert(data);
        }
    })
})


//Select DISTINCT room_id From hotel.booking Where NOT ((check_in, check_out) OVERLAPS ('2021-05-04', '2021-05-06'))