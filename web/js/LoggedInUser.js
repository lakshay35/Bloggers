// $(document).ready(function() {
//     $("#title h1").typed({
//         strings: ["Welcome To Bloggers."],
//         typeSpeed: 30
//     });
//     $(".typed-cursor" ).hide();
//
// });
//
$("#logoutButton").onclick(function() {
    $.ajax({
        url: "Blog",
        method: "post",
        data: {
            "logout": "logout"
        }
    });
});