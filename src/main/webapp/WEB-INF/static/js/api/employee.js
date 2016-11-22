function buildList() {

    //
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function (data) {
//        console.log(data)
        $.each(data, function (index, single) {
            $('#employeeList').append(single.firstName);
            $('#employeeList').append('<br>');
        })
    })
}

function buildTable() {
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function (data) {
        console.log(data)
        $.each(data, function (index, single) {

            $("#employee-table").find('tbody')
//                .append($('<tr>'))
//                .append($('<td>').text(single.id))
//                .append($('<td>').text(single.firstName + ' ' + single.lastName))
//                .append($('<td>').text(single.background))
//                .append($('<td>').text(single.projects))
//                .append($('<td>').add($('<button>').text("Edit")))

                .append("<tr>" +
                            "<td>" + single.id + "</td>" +
                            "<td>" + single.firstName + " " + single.lastName + "</td>" +
                            "<td>" + single.background + "</td>" +
                            "<td>" + "<select><option>(Select Project)</option></select>" + "</td>" +
                            "<td>" + "<button onclick='editEmployee(" + single.id + ")'>Edit</button>" + "</td>" +
                            "<td>" + "<button onclick='openDeleteConfirmationModal(" + single.id + ")'>Delete</button>" + "</td>" +

                        "</tr>")

        });
    });
}

function saveEmployee() {
    var id = $('#employeeId').val();
    var version = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var background = $('#inputBackground').val();

    var employee = {
        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        background: background,
        projects: []
    }

    console.log(employee);

    $.ajax({
        type: "post",
        data: employee,
        url: "/api/employee/",
        async: true,
        dataType: "json",
        success: function() {
            window.location.reload();
        },
        error: function() {
            alert("Failed To Insert Employee!")
        }
    })
}

function editEmployee(id) {

    //retrieve employee with passed in id
    $.getJSON('/api/employee/' + id, {
        ajax: 'true'
    }, function (employee) {
        console.log(employee)

        //populate values (hidden and input)
        $('#employeeId').val(employee.id);
        $('#employeeVersion').val(employee.version);
        $('#inputFirstName').val(employee.firstName);
        $('#inputLastName').val(employee.lastName);
        $('#inputBackground').val(employee.background);

        //open modal
        $('#employeeModal').modal('show');
    });

}

function openDeleteConfirmationModal(id) {

    //set the onclick of the delete button
    $('#confirmDelete').click(function() {
        deleteEmployee(id);

    })

    //open modal
    $('#employeeDeleteModal').modal('show');

}

function deleteEmployee(id) {

    $.ajax({
        type: "delete",
        url: "/api/employee/" + id,
        async: true,
        dataType: "json",
        success: function () {
            window.location.reload();
        }
    })
}