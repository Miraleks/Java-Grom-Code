package lesson30HW;

public class Controller {
    public void employeesByProject(String projectName) { // список сотрудников, работающих над заданным проектом
    }
    public void projectsByEmployee(Employee employee) { // список проектов, в которых участвует заданный сотрудник
    }
    public void employeesByDepartmentWithoutProject(DepartmentType departmentType) { // список сотрудников из заданного отдела, не участвующих ни в одном проекте
    }
    public void employeesWithoutProject() { // список сотрудников, не участвующих ни в одном проекте
    }
    public void employeesByTeamLead(Employee lead){ // список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    }
    public void teamLeadsByEmployee(Employee employee) { // список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    }
    public void employeesByProjectEmployee(Employee employee) { // список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    }
    public void projectsByCustomer(Customer customer) { // список проектов, выполняемых для заданного заказчика
    }
    public void employeesByCustomerProjects(Customer customer) { //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    }
}
