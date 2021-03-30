- Attribute selector convention:
.btn[data-state=default] { color: #333; } 
.btn[data-state=pressed] { color: #000; } 
.btn[data-state=disabled] { opacity: .5; pointer-events: none; }

<!-- HTML -->
<button class="btn" data-state="disabled">Disabled</button>
... 
Changing code in jquery

// bind a click handler to each button
$(".btn").bind("click", function(){
    // change the state to pressed
    $(this).attr('data-state', 'pressed');
});