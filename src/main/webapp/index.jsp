<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>Library Home</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-50">
    <!-- Navigation Bar -->
    <nav class="bg-teal-500 p-4 text-white shadow-md">
        <div class="container mx-auto flex justify-between">
            <h1 class="text-xl font-bold">Library</h1>
            <div>
                <a href="${pageContext.request.contextPath}/categories" 
                   class="mr-4 hover:text-teal-300">Categories</a>
                <a href="${pageContext.request.contextPath}/books" 
                   class="hover:text-teal-300">Books</a>
            </div>
        </div>
    </nav>

    <!-- Welcome Message -->
    <div class="container mx-auto text-center mt-20">
        <h2 class="text-4xl font-bold text-gray-800">Welcome to the Library!</h2>
        <p class="mt-6 text-lg text-gray-600">Browse our collection of categories and books.</p>

        <div class="mt-10">
            <a href="${pageContext.request.contextPath}/categories" 
               class="bg-teal-500 text-white px-6 py-3 rounded-lg hover:bg-teal-600 mr-4">
                Explore Categories
            </a>
            <a href="${pageContext.request.contextPath}/books" 
               class="bg-teal-500 text-white px-6 py-3 rounded-lg hover:bg-teal-600">
                View Books
            </a>
        </div>
    </div>
</body>

</html>
