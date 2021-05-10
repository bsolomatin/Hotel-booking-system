// $(function () {
//     $("#startDate").datepicker({
//         minDate: 0,
//         onSelect: function(selectedDate) {
//             let temp = new Date(selectedDate);
//             temp.setDate(temp.getDate() + 1);
//             $("#endDate").datepicker("option", "minDate", temp);
//             $(this).attr('value', $('#startDate').val());
//         }
//     });
//
//     $("#endDate").datepicker({
//        minDate: 0,
//        onSelect: function(selectedDate) {
//            $("#startDate").datepicker("option", "maxDate", selectedDate)
//            $(this).attr('value', $('#endDate').val());
//        }
//     });
// })
let reservations = new Array();

function createReservationIntervals(data) {
    reservations = [];
    for (let i = 0; i < data.length; i++) {
        let arr = new Array(data[i].checkIn, data[i].checkOut);
        reservations.push(arr);
    }
}

$(function () {
    $("#checkIn").datepicker({
        minDate: 0,
        dateFormat: "yy-mm-dd",
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
        onSelect: function(selectedDate) {
          $("#checkOut").datepicker("option", "minDate", selectedDate);
        }
    })

    $("#checkOut").datepicker({
        dateFormat: "yy-mm-dd",
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
            let fromDate = $("#checkIn").datepicker('getDate');
            let toDate = $("#checkOut").datepicker('getDate');
            for (let i = new Date(fromDate); i <= toDate; i.setDate(i.getDate() + 1)) {
                for(let j = 0; j < reservations.length; j++) {
                    if(reservations[j][0].indexOf(jQuery.datepicker.formatDate('yy-mm-dd', i)) != -1 ||
                        reservations[j][1].indexOf(jQuery.datepicker.formatDate('yy-mm-dd', i)) != -1) {
                        flag = false;
                    }
                }
            }
            if (!flag) {
                $($("#checkOut").val(""));
                alert("Test");
            }

            $("#checkIn").datepicker("option", "maxDate", date);
        }
    })
})

// $('#checkDate').datepicker({
//     //dateFormat: 'yyyy-mm-dd',
//     beforeShowDay: function (date) {
//         for (let i = 0; i < reservations.length; i++) {
//             let from = new Date(reservations[i][0]);
//             let to = new Date(reservations[i][1]);
//             date.setHours(0, 0, 0, 0);
//             from.setHours(0, 0, 0, 0);
//             to.setHours(0, 0, 0, 0);
//             if (date >= from.getTime() && date <= to) return false;
//         }
//         return [reservations.indexOf(date) == -1];
//     }
// });