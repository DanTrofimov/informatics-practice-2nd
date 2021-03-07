<#import "spring.ftl" as spring/>
<#import "../header.ftl" as header/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="<@spring.url '/styles/header.css' />" type="text/css">
    <link rel="stylesheet" href="<@spring.url '/styles/pages.css' />" type="text/css">
</head>
<body>
<@header.header />
<div class="page-content">
<p><strong><span style="font-family: arial, helvetica, sans-serif; color: #e74c3c; font-size: 12pt;">hello</span></strong></p>
<table style="border-collapse: collapse; width: 36.9452%; height: 118px;" border="1">
<tbody>
<tr>
<td style="width: 48.1144%;"><strong><span style="font-family: arial, helvetica, sans-serif; color: #e74c3c; font-size: 12pt;">name</span></strong></td>
<td style="width: 48.2303%;"><strong><span style="font-family: arial, helvetica, sans-serif; color: #e74c3c; font-size: 12pt;">soname</span></strong></td>
</tr>
<tr>
<td style="width: 48.1144%;">dan</td>
<td style="width: 48.2303%;">trofimoff</td>
</tr>
</tbody>
</table>
</div>
</body>
</html>
