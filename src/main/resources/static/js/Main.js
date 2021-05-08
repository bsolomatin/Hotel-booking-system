const xhr = new XMLHttpRequest();
let reservations = new Array();

function request(method, url, obj = null, callback) {
    xhr.open(method, url);
    xhr.onload = () => {
        if (xhr.status != 200) callback(new Error(`${xhr.status} - ${xhr.statusText}`));
        else callback(null, xhr.response);
    }

    xhr.onerror = () => callback(new Error(`${xhr.status} - ${xhr.statusText}`));
    xhr.send(JSON.stringify(obj));
}

function sendRequest(method, url, obj) {
    return new Promise((resolve, reject) => {
        console.warn("Promise " + url);
        request(method, `http://localhost:8080/${url}`, obj, (err, data) => {
            if (err) {
                reject(err)
            } else {
                resolve(data)
            }
        })
    })
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

$("#btn").on('click', function () {
    sendRequest("GET", 'bookings')
        .then((data) => tester(JSON.parse(data)))
})


function tester(data) {
    reservations = new Array();
    for (let i = 0; i < data.length; i++) {
        let arr = new Array(data[i].checkIn, data[i].checkOut);
        reservations.push(arr);
    }
}

$(function () {
    $("#from").datepicker({
        //dateFormat: "yyyy-mm-dd",
        beforeShowDay: function (date) {
            for (let i = 0; i < reservations.length; i++) {
                let from = new Date(reservations[i][0]);
                let to = new Date(reservations[i][1]);
                date.setHours(0, 0, 0, 0);
                from.setHours(0, 0, 0, 0);
                to.setHours(0, 0, 0, 0);
                if (date >= from.getTime() && date <= to) return false;
            }
            return [reservations.indexOf(date) == -1];
        }
    })

    $("#to").datepicker({
        //dateFormat: "yyyy-mm-dd",
        beforeShowDay: function (date) {
            for (let i = 0; i < reservations.length; i++) {
                let from = new Date(reservations[i][0]);
                let to = new Date(reservations[i][1]);
                date.setHours(0, 0, 0, 0);
                from.setHours(0, 0, 0, 0);
                to.setHours(0, 0, 0, 0);
                if (date >= from.getTime() && date <= to) return false;
            }
            return [reservations.indexOf(date) == -1];
        },
        onSelect: function (date) {
            let flag = true;
            let fromDate = $("#from").datepicker('getDate');
            let toDate = $("#to").datepicker('getDate');
            for (let i = new Date(fromDate); i <= toDate; i.setDate(i.getDate() + 1)) {
                for(let j = 0; j < reservations.length; j++) {
                    if(reservations[j][0].indexOf(jQuery.datepicker.formatDate('yy-mm-dd', i)) != -1 ||
                    reservations[j][1].indexOf(jQuery.datepicker.formatDate('yy-mm-dd', i)) != -1) {
                        flag = false;
                    }
                }
            }
            if (!flag) {
                $($("#to").val(""));
                alert("Test");
            }
        }
    })
})
$('#checkDate').datepicker({
    //dateFormat: 'yyyy-mm-dd',
    beforeShowDay: function (date) {
        for (let i = 0; i < reservations.length; i++) {
            let from = new Date(reservations[i][0]);
            let to = new Date(reservations[i][1]);
            date.setHours(0, 0, 0, 0);
            from.setHours(0, 0, 0, 0);
            to.setHours(0, 0, 0, 0);
            if (date >= from.getTime() && date <= to) return false;
        }
        return [reservations.indexOf(date) == -1];
    }
});


//Select DISTINCT room_id From hotel.booking Where NOT ((check_in, check_out) OVERLAPS ('2021-05-04', '2021-05-06'))