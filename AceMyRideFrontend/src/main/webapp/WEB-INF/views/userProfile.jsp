<%@include file="header.jsp" %>


  <style>
.menu-item.active {
  background-color: #D6D0DB;
}

.border-right {
  border-right-style: solid;
  border-right-width: 1px;
  border-right-color: grey;
}

.fa-user-circle {
  color: #6F06B8;
}

.fa-unlock {
  color: #8EBD10;
}

.fa-history {
  color: #76766D;
}

.fa-map-marker {
  color: #B12515;
}

.fa-credit-card-alt {
  color: #EBA219;
}

.fa {
  size: 20px;
}

.general {
  font-size: 20px;
  border-bottom-style: solid;
  border-bottom-width: 1px;
  border-bottom-color: grey;
}

.general-without-border {
  font-size: 20px;
}

.contents {
  padding-right: 50px;
}

.content-head {
  font-size: 22px;
  color: black;
  background-color: #C2D8D6;
  border-bottom-style: solid;
  border-bottom-width: 0.75px;
  border-bottom-color: #5E6362;
}

.view {
  border-bottom-style: solid;
  border-bottom-width: 0.5px;
  border-bottom-color: #BBC2C1;
}

.update {
  display:none;
  background-color: white;
  border-bottom-style: solid;
  border-bottom-width: 0.5px;
  border-bottom-color: #BBC2C1;
}

.parameter {
  padding-top: 16px;
  width: 200px;
  font-size: 15px;
  color: #434645;
}

.paramvalue {
  padding-top: 15px;
  width: 200px;
  font-size: 15px;
  color: #6C6F6E;
}

.new-parameter {
  padding-top: 14px;
  padding-bottom: 15px;
  width: 200px;
  font-size: 15px;
  color: #434645;
}

.new-paramvalue {
  padding-top: 13px;
  width: 200px;
  font-size: 15px;
  color: #6C6F6E;
}

.new-edit-link {
  padding-top: 10px;
}

.fa-pencil {
  font-size: 15px;
  color: #094F8C;
}

.fa-times {
  font-size: 15px;
  color: #094F8C;
}

.passForm {
  padding-left: 30px;
  background-color: white;
  border-bottom-style: solid;
  border-bottom-width: 0.5px;
  border-bottom-color: #BBC2C1;

}
</style>


  <div class="container-fluid">

    <div class="row">

      <div class="col-md-3">
        <div class="border-right">

          <div class="general menu-item active" data-target="details">
            <i class="fa fa-user-circle" aria-hidden="true"></i>General
            Details
          </div>
          <div class="general menu-item" data-target="changePass">
            <i class="fa fa-unlock" aria-hidden="true"></i>Change Password
          </div>
          <div class="general menu-item" data-target="orders">
            <i class="fa fa-history" aria-hidden="true"></i>Your Orders
          </div>
          <div class="general menu-item" data-target="address">
            <i class="fa fa-map-marker" aria-hidden="true"></i>Manage Address
          </div>
          <div class="general-without-border menu-item" data-target="payment">
            <i class="fa fa-credit-card-alt" aria-hidden="true"></i>Payment
            Options
          </div>

        </div>
      </div>


      <div class="col-md-9 contents">



        <div class="content-item active" data-target="details">

          <div class="content-head row">Your Info</div>

          <form action="submitUpdate">
            <div class="view row">
              <div class="parameter col-md-3 text-left">Name</div>
              <div class="paramvalue col-md-6">${user.name}</div>
              <div class="edit-link col-md-3 text-right" >
                <i class="fa fa-pencil" data-toggle="tooltip" data-target="editName"
                  title="Click to edit" aria-hidden="true"></i>
              </div>

            </div>

            <div class="update row" data-target="editName">
              <div class="new-parameter col-sm-3 text-left">Enter new
                name</div>
              <div class="new-paramvalue col-sm-6">
                <input type="text" name="name">
              </div>
              <div class="new-edit-link col-sm-3 text-right">
                <button type="submit" class="btn btn-primary">Update</button>
              </div>
              <div class="cancel-form col-md-3 text-right"
                data-target="editName">
                <i class="fa fa-times" data-toggle="tooltip" title="Cancel"
                  aria-hidden="true"></i>
              </div>

            </div>

            <div class="view row">
              <div class="parameter col-sm-3 text-left">Contact</div>
              <div class="paramvalue col-sm-6">${user.contact}</div>
              <div class="edit-link col-sm-3 text-right"
                >
                <i class="fa fa-pencil" data-toggle="tooltip" data-target="editContact"
                  title="Click to edit" aria-hidden="true"></i>
              </div>
            </div>

            <div class="update row" data-target="editContact">
              <div class="new-parameter col-sm-3 text-left">Enter new
                contact</div>
              <div class="new-paramvalue col-sm-6">
                <input type="text" name="contact">
              </div>
              <div class="new-edit-link col-sm-3 text-right">
                <button type="submit" class="btn btn-primary">Update</button>
              </div>
              <div class="cancel-form col-md-3 text-right"
                data-target="editContact">
                <i class="fa fa-times" data-toggle="tooltip" title="Cancel"
                  aria-hidden="true"></i>
              </div>
            </div>

          </form>
        </div>

        <div class="content-item" data-target="changePass">

          <div class="content-head row">Change Password</div>

          <form action="submitUpdate" onsubmit="return ComparePasswords()">


            <div class=" row ">

              <div class="passForm">

                <div class="row">
                  <div class="new-parameter col-sm-6 ">Current password</div>
                  <div class="new-paramvalue col-sm-6">
                    <input type="password" name="currentPassword" id="currentPassword">
                  </div>
                </div>
                <div class="row">
                  <div class="new-parameter col-sm-6 ">New password</div>
                  <div class="new-paramvalue col-sm-6 ">
                    <input type="password" name="newPassword" id="newPassword">
                  </div>
                </div>
                <div class="row">
                  <div class="new-parameter col-sm-6">Confirm password</div>
                  <div class="new-paramvalue col-sm-6">
                    <input type="password" name="againNewPassword" id="againNewPassword">
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-2"></div>
                  <div class="new-edit-link col-sm-2 text-right " style="padding-bottom:15px ">
                    <button type="submit" class="btn btn-primary">Update</button>
                  </div>

                </div>
              </div>

            </div>

          </form>
        </div>



      </div>
    </div>
  </div>






  <script type="text/javascript">
    $(document).ready(
        function() {

          $('[data-toggle="tooltip"]').tooltip();
          

          $('.content-item').hide();
          $('.content-item.active').show();
          
          $('.menu-item').click(
              function(event) {
                var target = $(event.target)[0];
                var openMenu = $('.menu-item.active');
                var menuToOpen = $(target);

                $(openMenu).removeClass('active');
                $(menuToOpen).addClass('active');
                var divToOpenName = $(target).attr(
                    'data-target');
                var openDiv = $('.content-item.active').toggle(
                    'fast');
                $(openDiv).removeClass('active');
                var divToOpen = $(
                    '.content-item[data-target='
                        + divToOpenName + ']').toggle(
                    'fast');
                divToOpen.addClass('active');
              });

          $('.edit-link').click(
              function(event) {
                var target = $(event.target)[0];
                var divToOpnName = $(target)
                    .attr('data-target');
                var opnDiv = $('.update.active').hide('fast');
                $(opnDiv).removeClass('active');
                var divToOpn = $(
                    '.update[data-target=' + divToOpnName
                        + ']').show('fast');
                $(divToOpn).addClass('active');
              });

          $('.cancel-form').click(function(event) {

            $('.update').hide();
          });
        });


    function ComparePasswords(){

          var currentPassword = document.getElementById("currentPassword").value;
          var newPassword = document.getElementById("newPassword").value;
          var confirmPassword = document.getElementById("againNewPassword").value;
          var flag=true;

          if(newPassword!=confirmPassword){
           alert("Re-entered password should be same as new password");
            flag=false;
    }

           /* if(!(currentPassword.equals(${user.password})))
           {
               alert("Wrong password");
             flag=false;
           }  */

          return flag;

    }
  </script>

<%@include file="footer.jsp" %>


</body>
</html>

