$('.modal').each(function(){
  var modalWidth = $(this).width(),
      modalMargin = '-' + (modalWidth/2) + 'px!important';
  $(this).css('margin-left',modalMargin);
});