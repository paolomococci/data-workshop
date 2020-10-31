yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('Spring Boot Groovy Template')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark'){
            a(href: "#", class: "navbar-brand", "customer")
            input(class: 'form-control form-control-dark w-100', type: 'text', placeholder: 'search')
        }
        div(class: 'container', style: 'margin-top: 100px;'){
            form(action: '/create', method: 'post'){
                div(class: 'row'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'name', name: 'name')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'surname', name: 'surname')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', placeholder: 'email', name: 'email')
                    }
                    div(class: 'col'){
                        input(type: 'submit', class: 'btn btn-primary', value: 'add')
                    }
                }
            }
            table(class: 'table', style: 'margin-top: 50px;'){
                thead(){
                    tr(){
                        th('ID')
                        th('name')
                        th('surname')
                        th('email')
                        th('actions')
                    }
                }
                tbody(){
                    customers.each { customer ->
                        tr(){
                            td("$customer.id")
                            td("$customer.name")
                            td("$customer.surname")
                            td("$customer.email")
                            td(){
                            a(href: "/update/$customer.id", class: "btn btn-info btn-sm", style: 'margin-right: 5px;', "update")
                            a(href: "/delete/$customer.id", class: "btn btn-danger btn-sm", "delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
