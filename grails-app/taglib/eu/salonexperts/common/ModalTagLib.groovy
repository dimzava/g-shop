package eu.salonexperts.common

class ModalTagLib {
	
	static namespace = "se"
	
	/**
	 * Creates a twitter bootstrap modal window used for delete-like actions
	 * 
	 * @attr divId the id of the wrapping div; if not specified, "modal-window" will be used
	 * @attr divCssClass one or more css classes for the wrapping div; if not specified, "modal hide fade" will be used
	 * @attr header the text for the header/title of the modal window
	 * @attr body the text displayed for the main body of the modal window
	 * @attr formName the modal's form name
	 * @attr controller the controller part in the form's URL; if not specified, the current controller will be used
	 * @attr action the action part in the form's URL; if not specified, the "index" action will be used
	 * @attr id the id part in the form's URL; if not specified, "params.id" will be used
	 * @attr mainBtnCssClass the css class for the main button of the modal window; if not specified, "btn" will be used
	 * @attr mainBtnLabel the text for the main button of the modal window; if not specified, "btn secondary" will be used
	 * @attr secondaryBtnCssClass the css class for the secondary button of the modal window
	 * @attr secondaryBtnLabel the text for the secondary button of the modal window
	 */
	def modalDelete = {attrs ->
		attrs.header = g.message(code: "action.delete.entity", args: [g.message(code: "${request.entity}.genitive")])
		attrs.body = g.message(code: "action.delete.entity.confirm", args: [g.message(code: "${request.entity}.accusative"), request.entityIdentifyingProperty])
		attrs.formName = "modal-delete-form"
		attrs.action = "delete"
		attrs.mainBtnCssClass = "btn danger"
		attrs.mainBtnLabel = g.message(code: "action.delete.confirm.true")
		attrs.secondaryBtnCssClass = "btn secondary dismiss"
		attrs.secondaryBtnLabel = g.message(code: "action.delete.confirm.false")
		renderModal(attrs)
	}
	
	private def renderModal(attrs) {
		attrs.divId = attrs.divId ?: "modal-window"
		attrs.divCssClass = attrs.divCssClass ?: "modal hide fade"
		attrs.header = attrs.header ?: "???No header defined???"
		attrs.body = attrs.body ?: "???No header defined???"
		attrs.formName = attrs.formName ?: ""
		attrs.controller = attrs.controller ?: controllerName
		attrs.controller = attrs.controller ?: ""
		attrs.id = attrs.id ?: params.id
		attrs.mainBtnCssClass = attrs.mainBtnCssClass?: "btn"
		attrs.mainBtnLabel = attrs.mainBtnLabel ?: "???No label defined???"
		attrs.secondaryBtnCssClass = attrs.secondaryBtnCssClass?: "btn secondary"
		attrs.secondaryBtnLabel = attrs.secondaryBtnLabel ?: "???No label defined???"
		out << render(template: "/common/modal", model: attrs)
	}
}
