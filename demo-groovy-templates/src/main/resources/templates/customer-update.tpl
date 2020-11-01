yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('Spring Boot Groovy Template')
        link(rel: "stylesheet", href: "/webjars/bootstrap/4.5.3/css/bootstrap.min.css")
    }
    body {
        nav(class: 'navbar navbar-expand-md navbar-dark bg-dark'){
            a(href: "#", class: "navbar-brand", "customer-update")
            input(class: 'form-control form-control-dark w-100', type: 'text', placeholder: 'search')
        }
        div(class: 'container', style: 'margin-top: 100px;'){
            form(action: '/update', method: 'post'){
                div(class: 'row'){
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', value: "$updated.name", name: 'name')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', value: "$updated.surname", name: 'surname')
                    }
                    div(class: 'col'){
                        input(type: 'text', class: 'form-control', value: "$updated.email", name: 'email')
                    }
                    input(type: 'hidden',  value: "$updated.id", name: 'id')
                    div(class: 'col'){
                        input(type: 'submit', class: 'btn btn-primary', value: 'update')
                    }
                }
            }
        }
    }
}
