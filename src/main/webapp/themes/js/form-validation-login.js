
//  dang ky
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms1 = document.querySelectorAll('.frm_login')

  // Loop over them and prevent submission
  Array.from(forms1).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  }
 
  )

 
})()
