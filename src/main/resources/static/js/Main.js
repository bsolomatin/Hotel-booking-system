$(function() {
})

document.addEventListener("DOMContentLoaded", function() {
    sendRequest("GET", `rooms`)
        .then((data) => {
            showRooms(JSON.parse(data));
            console.warn(JSON.parse(data));
        })
        //.catch((error) => sendRequest("GET", "/error"));
})

function showRooms(data) {
    for (let i = 0; i < data.length; i++) {
        $(".cardBody").append(`
        <div class="col">
            <div class="card text-center" style="width: 18rem">
                <div class="card-body">
                    <h5 class="card-title">Комната № ${data[i].id}</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Этаж № ${data[i].flat}</li>
                        <li class="list-group-item">Количество кроватей: ${data[i].numberOfBed}</li>
                        <li class="list-group-item">Цена за сутки, рублей: ${data[i].price}</li>
                    </ul>
                    <p class="card-text">Кликните по кнопке ниже, чтобы получить больше информации</p>
                    <a href="room/${i}" class="btn btn-primary">Подробнее</a>
                </div>
            </div>
        </div>`);
    }
}

$(".admin.nav-item").click(function () {
    sendRequest("GET", `admin/${$(this).attr("id")}`)
        .then((data) => console.log(data))
        //$.fn.refreshTable(JSON.parse(data)))
        .catch((error) => new Error());
})


$.fn.refreshTable = function (data) {
    $("#table").empty();
    $.each(data, function (i, item) {
        $("#table").append('<tr>');
        $.each(item, function (j, itemValue) {
            if (i == 0) $("#table").append($(`<th>${j}</th>`));
            else $("#table").append($(`<td>${itemValue}</td>`))
        })
        $("#table").append("</tr>");
    })
}



//Select DISTINCT room_id From hotel.booking Where NOT ((check_in, check_out) OVERLAPS ('2021-05-04', '2021-05-06'))