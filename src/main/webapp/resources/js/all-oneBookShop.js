$(document).ready(function () {
    $('#rootCategory').on('change', function () {
        var category = $(this).val();
        $.ajax({
            url: "/onebookshop/seller/getSubCategory",
            type: 'post',
            dataType: 'text',
            data: {'category': category},
            success: function (data) {
                var htmlString = "";
                if (data.indexOf("|") != -1) {
                    var item = data.split("|");
                    for (var i in item) {
                        htmlString += "<option value=\'" + category + "." + item[i] + "\'>" + item[i] + "</option>";
                    }
                    $('#subCategory').html(htmlString);
                    $('#subCategory').trigger('change');
                } else {
                    $('#subCategory').html("<option disabled=\'disabled\' selected> Not Available</option>");
                    $('#subCategory').trigger('change');
                }
            },
            error: function (xhr, error) {
                console.log(error);
            }
        });
    });

    $('#subCategory').on('change', function () {
        var category = $(this).val();
        $.ajax({
            url: "/onebookshop/seller/getSubSubCategory",
            type: 'post',
            dataType: 'text',
            data: {'category': category},
            success: function (data) {
                var htmlString = "";
                if (data.indexOf("|") != -1) {
                    var item = data.split("|");
                    for (var i in item) {
                        htmlString += "<option value=\'" + category + "." + item[i] + "\'>" + item[i] + "</option>";
                    }
                    $('#subSubCategory').html(htmlString);
                } else
                    $('#subSubCategory').html("<option disabled='disabled' selected> Not Available</option>");
            },
            error: function (xhr, error) {
                console.log(error);
            }
        });
    });

    $('.accordion-group').on('click', function () {
        if(!$(this).find('.accordion-body').hasClass('show')){
            $(this).find('.accordion-heading').addClass('accordion-opened');
        }
        else{
            $(this).find('.accordion-heading').removeClass('accordion-opened');
        }
    });
});

function fnAddtoCart(){
    var book = {};
    book.bookId = $('#bookId').val();
    book.quantity = '1';


    $.ajax({
        url: "/onebookshop/user/book/addToCart",
        type: 'POST',
        dataType: "json",
        data: {"book" : JSON.stringify(book)},

        success: function (data) {
            //alert(data['cartQuantity']);
            $('#lblCartCount').html(data['cartQuantity']);
        },
        error: function (xhr, error) {
            console.log(error);
        }
    });
}

function fnLogout(){

}


