<!-- Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
  <form method="POST" action="addEmployee.do">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Add employee</h4>
      </div>
      
      <div class="modal-body">
      
	        <div class="input-group">
			  <span class="input-group-addon">First name</span>
			  <input type="text" class="form-control" required name="firstName">
			</div>
			<br/>
			<div class="input-group">
			  <span class="input-group-addon">Last name</span>
			  <input type="text" class="form-control" required name="lastName">
			</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Add</button>
      </div>
    </div>
   </form>
  </div>
</div>