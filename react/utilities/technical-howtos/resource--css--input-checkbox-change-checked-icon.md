``` CSS
input,
label span{
  display: none;
  visibility: hidden;
}

label {
  display: block;
  background: grey;
  width: 50px;
  height: 50px;
}

input:checked + label{
  background: green;
}

```

```HTML
<!DOCTYPE html>
<html>
<head>
<title>Font Awesome Icons</title>
<style>
#cb {
  visibility: hidden;
}

input#cb::after {
  visibility: visible;
  content: "F";
  color: red;
  background: green;
  padding: 8px;
}

input#cb:checked::after {
  content: " T ";
  color: green;
  background: red;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<i class="fa fa-car"></i>
<i class="fa fa-car" style="font-size:48px;"></i>
<i class="fa fa-car" style="font-size:60px;color:red;"></i>
<input type="checkbox" id="cb">
</body>
</html>

```