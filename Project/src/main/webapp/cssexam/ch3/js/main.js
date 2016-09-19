

$(document).ready(function(){
	$("#gnb ul ul").hide();
	$("#gnb>ul>li").hover(function(){
		$("#gnb ul ul").stop().slideDown()
	}, function(){
		$("#gnb ul ul").stop().slideUp()
	});

   /*$(".mobiletogglebutton").click(function() { 
    $("#gnb").slideToggle(300); }); */
	
	$('.bxslider').bxSlider({
  	auto: true,
  	autoControls: true,
  	pause: 3000,
  	slideMargin: 20	
  	});
});

$(function() {
 $(window).scroll(function() {
  if($(this).scrollTop() != 0) {
   $('#backtotop').fadeIn(); 
  } else {
   $('#backtotop').fadeOut();
  }
 });
 
 $('#backtotop').click(function() {
  $('body,html').animate({scrollTop:0},800);
 }); 
});

var checkNum = 1;
var checkWidth = $(window).width();
$(window).resize(function(){
  checkWidth = $(window).width();
$(".mobiletogglebutton").click(function(){
      if((checkNum == 1) && (checkWidth<=800)){
        checkNum = 0;
        $("#gnb").hide(); 
        $(".mobiletogglebutton").click(function() { 
        $("#gnb").slideToggle(300); });  
      } 
    })
});