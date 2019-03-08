$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if(o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
        o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
 };

 $(function() {
    $('form').on('submit', function(e) {
      e.preventDefault();

      var formData = $(this).serializeObject();
      $.ajax({
        type: "POST",
        url: "SubmitServlet",
        data: JSON.stringify(formData),
        success: function(data){console.log("yayyy");},
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
          }
      });
    });
});