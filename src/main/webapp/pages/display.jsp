<html>
<head>
</head>
<body>

	File uploaded to : <%= request.getAttribute("uploadedFilePath") %>
        <br/>
        Comment : <%= request.getAttribute("comment") %>
         <br/>
        Readfile : <%= request.getAttribute("readfile") %>
        <br/>
        <br/>
	<br/><br/>
	<a href="upload/<%= request.getAttribute("uploadedFileName") %>">Click here to download it</a>

</body>
</html>