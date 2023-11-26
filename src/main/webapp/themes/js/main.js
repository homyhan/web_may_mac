$(document).ready(function(){
    $(window).scroll(function() {
        if ($(this).scrollTop() > 100) {
            $("#hip_page").css("display","flex")
            $("#to_top_btn").css("display","block");
        } else {
            $("#hip_page").css("display","none")
            $("#to_top_btn").css("display","none");
        }
        if($(this).scrollTop() > 100){
            $("#header").addClass( "sticky" );
            $("#top-head").css("display", "none");           
            $("#logo").css("width", "100px");           
            $("main").css( "padding-top", "150px" );
        }else{
            $("#header").removeClass( "sticky" );
            $("#top-head").css("display", "block");
            $("#logo").css("width", "150px"); 
            $("main").css( "padding-top", "0" );
        } 
    });
    // get size product
    var opts = $(".opt");
            console.log(opts.length);
            for(var i = 0; i < opts.length; i++){
                $("#opt"+i).on("click", function(){
                    console.log($(this).val());
                    $("#get_size_prod").text($(this).val());
                    $("#select_collapse").removeClass("show");
                })
            }
}
)
        
function showImageItem(imgs) {
            var getItemImg = document.getElementById("get_pict");
            getItemImg.src = imgs.src;
}
function likeProduct(){
    $('.btn-like').on('click', function(){
        var valBtn = $(this).val();
        if($(this).hasClass('active')){
            $(this).removeClass('active');
            console.log('UnLiked: ' + valBtn);
        }else{
            $(this).addClass('active');
            console.log('Liked: ' + valBtn);
        }
        
    })
}
function countProduct(){
    var products = $('.product-item').length;
    console.log(products);
    $("#getTotalProduct").jsp(products);
}

likeProduct();
countProduct();



