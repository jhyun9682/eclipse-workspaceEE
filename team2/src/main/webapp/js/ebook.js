/**
 * 
 */
function ebookBuy() {
		document.add_cart_form.action = "ebook_insert_action.jsp";
		document.add_cart_form.method = "POST";
		document.add_cart_form.submit();
	}
	
	
function setCookies(){
		document.ebook.action = "ebook_registered.jsp";
		document.ebook.method = "POST";
		document.ebook.submit();
	
}