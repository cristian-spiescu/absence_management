<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
  <form method="POST" action="updateEmployee.do">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Edit employee</h4>
      </div>
      
      <div class="modal-body">
      
	        <div class="input-group">
			  <span class="input-group-addon">First name</span>
			  <input id="firstName" type="text" class="form-control" required name="firstName">
			</div>
			<br/>
			<div class="input-group">
			  <span class="input-group-addon">Last name</span>
			  <input id="lastName" type="text" class="form-control" required name="lastName">
			</div>
			  <input id="employeeId" type="hidden" class="form-control" name="employeeId">

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Update</button>
      </div>
    </div>
   </form>
  </div>
</div>