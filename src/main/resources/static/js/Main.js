// document.addEventListener("DOMContentLoaded", function() {
//     sendRequest("GET", `rooms`)
//         .then((data) => showRooms(JSON.parse(data)))
//         .catch((error) => sendRequest("GET", "/error"));
// })

$("#search").on('submit', function (event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("search"));
    //console.log($("#search").serialize());
    $.ajax({
        processData: false,
        contentType: false,
        type: "POST",
        url: "/search",
        data: formData,
        success: function (data) {
            showRooms(data);
        }
    })
})

function showRooms(data) {
    console.warn(data);
    for (let i = 0; i < data.length; i++) {
        $(".container").append(`
        <div class="row mt-2" id="accordionExample">
        <div class="offset-2 offset-lg-3 col-8 col-lg-6">
            <div class="card" style="width: 100%">
                <div id="carouselExampleIndicators${i}" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-bs-target="#carouselExampleIndicators${i}" data-bs-slide-to="0" class="active"></li>
                        <li data-bs-target="#carouselExampleIndicators${i}" data-bs-slide-to="1"></li>
                        <li data-bs-target="#carouselExampleIndicators${i}" data-bs-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="w-100" src="https://picsum.photos/1920/1080?random=1">
                        </div>
                        <div class="carousel-item">
                            <img class="w-100" src="https://picsum.photos/1920/1080?random=2">
                        </div>
                        <div class="carousel-item">
                            <img class="w-100" src="https://picsum.photos/1920/1080?random=3">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators${i}" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators${i}" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
                <div class="card-body">
                    <h5 class="card-title text-center">${data[i].roomType.title}</h5>
                    <ul class="list-group list-group-flush">
                         <li class="list-group-item">Количество комнат: ${data[i].roomType.numberOfRooms}</li>
                         <li class="list-group-item">Цена за сутки, рублей: ${data[i].roomType.price}</li>
                    </ul>
                    <p class="card-text">Кликните по кнопке ниже, чтобы проверить наличие свободных дат</p>
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${i}"
                            aria-expanded="true" aria-controls="collapse${i}"></button>
                </div>
                <div id="collapse${i}" class="accordion-collapse collapse" aria-labelledby="heading${i}" data-bs-parent="#accordionExample">
                    <div class="accordion-body accbody{i}">
                        ${data[i].roomType.description}
                    </div>
                </div>
                <div class="blockForm">
                <form action="/user/book" method="POST">
                    <input type="hidden" value="${$("#cI").val()}" id="checkIn" data-date-format="yyyy-mm-dd" name="checkIn">
                    <input type="hidden" value="${$("#cO").val()}" id="checkOut" data-date-format="yyyy-mm-dd" name="checkOut">
                    <input type="hidden" value="${data[i].id}" id="roomId" name="roomId">
                    <input type="hidden" value="" id="userId" name="roomId">
                    <input type="sumbit" class="btn btn-primary" value="Забронировать">
                </form>
                </div>
            </div>
        `);

        for (let j = 0; j < data[i].roomType.features.length; j++) {
            $(".accbody${i}").append(`<i class="fas ${data[i].roomType.features[j].icon} fa-3x"}></i> <p>${data[i].roomType.features[j].description}</p>`)
        }
    }
        // $(".fbody").append(`<div id="collapse${i}" class="accordion-collapse collapse" aria-labelledby="heading${i}" data-bs-parent="#cardCollapse">
        //     <div class="accordion-body body${i}">
        //     </div>
        // </div>`);
//
//         $(".container").append(`
// <div class="col">
// <div class="card text-center" style="width:18rem">
//         <div id="carouselExampleIndicators${i}" class="carousel slide" data-bs-ride="carousel">
//             <div class="carousel-indicators">
//                 <button type="button" data-bs-target="#carouselExampleIndicators${i}" data-bs-slide-to="0" class="active"></button>
//                 <button type="button" data-bs-target="#carouselExampleIndicators${i}" data-bs-slide-to="1"></button>
//                 <button type="button" data-bs-target="#carouselExampleIndicators$[i}" data-bs-slide-to="2"></button>
//             </div>
//             <div class="carousel-inner">
//                 <div class="carousel-item active">
//                     <img class="d-block w-100" src="https://picsum.photos/1920/1080?random=1" alt="Photo">
//                 </div>
//                 <div class="carousel-item">
//                     <img class="d-block w-100" src="https://picsum.photos/1920/1080?random=2" alt="Photo">
//                 </div>
//                 <div class="carousel-item">
//                     <img class="d-block w-100" src="https://picsum.photos/1920/1080?random=3" alt="Photo">
//                 </div>
//             </div>
//             <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators${i}" data-bs-slide="prev">
//                 <span class="carousel-control-prev-icon" aria-hidden="true"></span>
//                 <span class="visually-hidden">Previous</span>
//             </button>
//             <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators${i}" data-bs-slide="next">
//                 <span class="carousel-control-next-icon" aria-hidden="true"></span>
//                 <span class="visually-hidden">Next</span>
//             </button>
//         </div>
//                 <div class="card-body">
//                     <h5 class="card-title">${data[i].roomType.title}</h5>
//                     <ul class="list-group list-group-flush">
//                         <li class="list-group-item">Количество комнат: ${data[i].roomType.numberOfRooms}</li>
//                         <li class="list-group-item">Цена за сутки, рублей: ${data[i].roomType.price}</li>
//                     </ul>
//                     <p class="card-text">Кликните по кнопке ниже, чтобы проверить наличие свободных дат</p>
//                     <button type="button" id="${data[i].id}" class="btn btn-primary" onclick="modalClick(this)">Бронирование</input>
//                     <button type="accordion-button collapsed" type="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="collapse${i}" data-bs-target="#collapse${i}">Подробнее</button>
//                 </div>
//                 </div>
//         </div>
// `);
//         fillBody(data[i], i);
//     }

}

// function fillBody(data, i) {
//     console.log(data);
//     for (let j = 0; j < data.roomType.features.length; j++) {
//         console.warn( " Get" + data.roomType.features[j].icon + " " + data.roomType.features[j].description);
//         $(`.body${i}`).append(`<p>${data.roomType.features[j].icon}</p> <p>${data.roomType.features[j].description}</p>`);
//     }
// }
//
// function modalClick(btn) {
//     $("#roomId").val(`${btn.id}`);
//     sendRequest("GET", `bookings/${btn.id}`)
//         .then((data) => createReservationIntervals(JSON.parse(data)))
//     $("#exampleModal").modal('toggle');
// }
//

// $.fn.refreshTable = function (data) {
//     $("#table").empty();
//     $("#table").append(`<thead><tr id="head"></tr></thead>`);
//     $("#table").append(`<tbody id="body"></tbody>`)
//     let str = ``;
//     console.warn("size " +data.length);
//     $.each(data, function (i, item) {
//         str = `<tr>`;
//         console.warn(data[i] + " - " + data[i].id);
//         //$("#body").append('<tr>');
//         $.each(item, function (j, itemValue) {
//             if (i == 0) {
//                 $("#head").append($(`<th scope="col">${j}</th>`));
//             }
//                 str += `<td>${itemValue}</td>`;
//                 //$("#body").append($(`<td>${itemValue}</td>`))
//         })
//         $("#head").append(`<th scope="col">Редактировать</th>`);
//         str += `</tr>`;
//         $("#body").append(str);
//         //$("#body").append("</tr>");
//     })
// }


// $(".admin.nav-item").click(function () {
//     $.ajax({
//         type: "GET",
//         url: `admin/${$(this).attr("id")}`,
//         success: function (data) {
//             $(".result").html(data);
//         }
//     })
// })


$("#blockForm").on('submit', function (e) {
    e.preventDefault();
    let formData = new FormData(document.getElementById("blockForm"));
    console.log(formData.entries());
    $.ajax({
        processData: false,
        contentType: false,
        type: "POST",
        url: "/test",
        data: formData,
        success: function (data) {
            alert(data);
        }
    })
})


$("#testbtn").on("click", function() {
    $.ajax({
        type: "GET",
        url: "/admin/testuser",
        success: function(data) {
            $(".table").html(data);
        }
    });
})




// $(".iconsBtn").on('click', function() {
//     alert("Call");
//     $.ajax({
//         type: "GET",
//         url: `/admin/users/${id}`,
//         success: function (data) {
//             $(".result").html(data);
//         }
//     });
// })
//Select DISTINCT room_id From hotel.booking Where NOT ((check_in, check_out) OVERLAPS ('2021-05-04', '2021-05-06'))