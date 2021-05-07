const xhr =new XMLHttpRequest();

function request(method, url, obj = null, callback) {
    xhr.open(method, url);
    xhr.onload = () => {
        if(xhr.status != 200) callback(new Error(`${xhr.status} - ${xhr.statusText}`));
        else callback(null, xhr.response);
    }

    xhr.onerror = () => callback(new Error(`${xhr.status} - ${xhr.statusText}`));
    xhr.send(obj);
}
function sendRequest(method, url, obj) {
    return new Promise((resolve, reject) => {
        console.warn("Promise " + url);
        request(method, `http://localhost:8080/${url}`, obj, (err, data) => {
            if (err) {reject(err)}
            else {resolve(data)}
        })
    })
}

$(".admin.nav-item").click(function() {
    sendRequest("GET",$(this).attr("id"))
        //.then((data) => $.fn.refreshTable(JSON.stringify(data)))
        .then((data) => console.log(data));
    console.log($(this).attr("id"));
})

let btn = document.getElementById("test")
btn.addEventListener("click", function() {
    sendRequest("GET", "bookings")
        .then((data) => $.fn.refreshTable(JSON.parse(data)));
})

$.fn.refreshTable = function(data) {
    $("#table").empty();
    // for(let i = 0; i < data.length; i++) {
    //     for(const [key, value] of Object.entries(data[i])) {
    //     }
    // }

    $.each(data, function(i, item) {
        $("#table").append('<tr>');
        $.each(item, function(j, itemValue) {
            if(i == 0) $("#table").append($(`<th>${j}</th>`));
            else $("#table").append($(`<td>${itemValue}</td>`))
        })
        $("#table").append("</tr>");
    })
}