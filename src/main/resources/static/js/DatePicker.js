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