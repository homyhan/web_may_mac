var table = '#mytable';
$('#maxRows').on('change', function(){
  console.log($(this).val());
  $('.pagination').jsp('');
  var trnum = 0;
  var maxRows = parseInt($(this).val())
  var totalRows = $(table + ' tbody tr').length
  $(table + ' tr:gt(0)').each(function(){
    trnum++;
    if(trnum > maxRows){
      $(this).hide();
    }
    if(trnum <= maxRows){
      $(this).show();
    }
  })
  if(totalRows > maxRows){
    var pagenum = Math.ceil(totalRows/maxRows);
    for(var i=1; i<=pagenum;){
      $('.pagination').append('<li data-page="' + i + '" class="me-2"><button class="btn btn-secondary">'+ i++ +'<span class="sr-only"></span></button></li>').show();
    }
  }
  $('.pagination li:first-child').addClass('active');
  $('.pagination li').on('click', function(){
    var pageNum = $(this).attr('data-page');
    console.log("li click: " +pageNum);
    var trIndex = 0;
    $('.pagination li').removeClass('active');
    $(this).addClass('active');
    $(table+' tr:gt(0)').each(function(){
      trIndex++;
      if(trIndex > (maxRows*pageNum) || trIndex <= ((maxRows*pageNum)-maxRows)){
        $(this).hide();
      }else{
        $(this).show();
      }
    })
  })
})
$(function(){
  $('table tr:eq(0)').prepend('<th>STT</th>');
  var id = 0;
  $('table tr:gt(0)').each(function(){
    id++;
    $(this).prepend('<td>'+ id + '</td>');
  })
})