<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <title>Category List</title>
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

    <!-- Page Content -->
    <div class="container mx-auto mt-8">
        <h1 class="text-center text-3xl font-bold text-gray-800 mb-6">Category List</h1>

        <table class="table-auto w-3/4 mx-auto border-collapse border border-gray-300">
            <thead>
                <tr class="bg-teal-100">
                    <th class="border border-gray-300 px-4 py-2">ID</th>
                    <th class="border border-gray-300 px-4 py-2">Name</th>
                    <th class="border border-gray-300 px-4 py-2">Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr class="hover:bg-teal-50">
                        <td class="border px-4 py-2">${category.id}</td>
                        <td class="border px-4 py-2">
                            <a href="${pageContext.request.contextPath}/books?category=${category.name}" 
                               class="text-teal-600 hover:underline">${category.name}</a>
                        </td>
                        <td class="border px-4 py-2">${category.description}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>