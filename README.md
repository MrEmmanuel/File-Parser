# File-Parser

A basic implementation of a file parser to convert the contents of the file and
store the records into a database.
The base64 image data processed from the flat file is being converted into a
physical file with the format as prescribed in the flat file.


The database record (AccountProfile) contain the following fields:
1.Account holder name
2.Account holder surname
3.httpImageLink

This is a Springboot application with a rest endpoint to handle
the httpImageLink.
