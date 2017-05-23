
<script src="${context}/assets/js/ajax.googleapis.com_ajax_libs_jquery_1.7.2_jquery.min.js" type="text/javascript"></script>
<script src="${context}/assets/js/material.js" type="text/javascript" >
    $.material.init()
    $.material.ripples()
    $.material.input()
    $.material.checkbox()
    $.material.radio()
    $.material.options = {
    "withRipples": ".btn:not(.btn-link), .card-image, .navbar a:not(.withoutripple), .nav-tabs a:not(.withoutripple), .withripple",
    "inputElements": "input.form-control, textarea.form-control, select.form-control",
    "checkboxElements": ".checkbox > label > input[type=checkbox]",
    "radioElements": ".radio > label > input[type=radio]"
}
</script>
</body>
</html>