/**
 * Created by zhongshuzhi on 2016-08-16.
 */
$(function () {
    bindCategoryBtns()
});
function bindCategoryBtns() {
    $("#newComponentCategoryBtn").on("click", function () {
        $('#newComponentCategoryModal').modal('show');
    });
    $("#saveDeleteCategoryBtn").on("click", deleteComponentCategory);
    $("#saveEditCategoryBtn").on("click", editComponentCategory);
    $("#saveNewCategoryBtn").on("click", newComponentCategory);
}

function newComponentCategory() {
    var title = $("#newCategoryName").val();
    $.ajax({
        method: "POST",
        url: "/spdmp/add-component-category",
        data: title,
        contentType: "application/json;charset=utf-8",
        cache: false,
        success: function (data) {
            if (data.code == 1) {
                // alert("新建成功");
                $('#newComponentCategoryModal').modal('hide');
                $("#newCategoryName").empty();
                getCategoryChoices2();
            } else if (data.code == -604) {
                alert(data.msg);
            } else if (data.code == -605) {
                alert(data.msg);
            }
        },
        error: function () {
            alert("failed");
        }
    })
}

function deleteComponentCategory() {
    var title = $("#deleteCateName").html()
    $.ajax({
        method: "POST",
        url: "/spdmp/delete-component-category",
        data: title,
        contentType: "application/json;charset=utf-8",
        cache: false,
        success: function (data) {
            if (data.code == 1) {
                // alert("删除成功");
                $('#deleteComponentCategoryModal').modal('hide');
                $("#deleteCateName").empty();
                getCategoryChoices2();
            }
        },
        error: function () {
            alert("failed");
        }
    })
}

function editComponentCategory() {
    var editMsg = {
        originalTitle: $("#renameCateName").html(),
        title: $("#editCategoryName").val()
    }
    $.ajax({
        method: "POST",
        url: "/spdmp/rename-component-category",
        data: JSON.stringify(editMsg),
        contentType: "application/json;charset=utf-8",
        cache: false,
        success: function (data) {
            if (data.code == 1) {
                // alert("编辑成功");
                $('#renameCategoryModal').modal('hide');
                $("#renameCateName").empty();
                $("#editCategoryName").empty();
                getCategoryChoices2();
            } else if (data.code == -604) {
                alert(data.msg);
            } else if (data.code == -605) {
                alert(data.msg);
            }
        },
        error: function () {
            alert("failed");
        }
    })
}