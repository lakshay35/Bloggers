function submitButtonClicked(event) {
    event.preventDefault();
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(re.test($("#email").val())) {
        $.ajax({
            type: "get",
            url: "Blog",
            data: {
                "checkIfUserExists": 1,
                "username": $("#username").val(),
                "email": $("#email").val()
            },
            success: function(responseText) {
                if(responseText.statusCode != 200) {
                    if(responseText.text == "email/username") {
                        alert("The email address and username you provided are both already in use. Please use another email address and username.");
                    }
                    else if(responseText.text == "email") {
                        alert("The email address you provided is already in use. Please use another email address.");
                    } else if(responseText.text == "username"){
                        alert("The username you provided is already in use. Please use another username.");
                    }
                    location.reload();
                } else {
                    $.ajax({
                        type: "post",
                        url: "Blog",
                        data: {
                            "signUp": "signUp",
                            "fname": $("#fname").val(),
                            "lname": $("#lname").val(),
                            "email": $("#email").val(),
                            "username": $("#username").val(),
                            "password": $("#password").val(),
                            "contact": $("#contact").val()
                        },
                        success: function(responseText) {
                            alert(responseText);
                        }
                    });
                }
            },
            error: function() {
                alert("Oops an error occurred. Please try signing up again");
                location.reload();
            }

        });
    } else {
        alert("Invalid email address. Please try signing up with a valid email address");
        location.reload();
    }
}
