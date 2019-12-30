<template>
  <div
    id="app"
    class="small-container"
  >
    <h1>Students</h1>

    <student-form @add:student="addStudent" />
    <student-table
      :students="students"
      @delete:student="deleteStudent"
      @edit:student="editStudent"
    />
  </div>
</template>

<script>
import StudentTable from '@/components/StudentTable.vue'
import StudentForm from '@/components/StudentForm.vue'
export default {
  name: "app",
  components: {
    StudentTable,
    StudentForm,
  },
  data() {
    return {
      students: []
    }
  },
  mounted() {
    this.getStudents()
  },
  methods: {
    async getStudents() {
      try {
        const response = await fetch('http://127.0.0.1:8080/api/v1/students', {mode: 'no-cors'})
        const data = await response.json()
        this.students = data
      } catch (error) {
        error;
      }
    },
    async addStudent(student) {
      try {
        const response = await fetch('http://localhost:8080/api/v1/students', {
          method: 'POST',
          body: JSON.stringify(student),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        this.students = [...this.students, data]
      } catch (error) {
        error;
      }
    },
    async editStudent(id, updatedStudent) {
      try {
        const response = await fetch(`http://localhost:8080/api/v1/students/${id}`, {
          method: 'PUT',
          body: JSON.stringify(updatedStudent),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        this.students = this.students.map(student => student.id === id ? data : student)
      } catch (error) {
        error;
      }
    },
    async deleteStudent(id) {
      try {
        await fetch(`http://localhost:8080/api/v1/students/${id}`, {
          method: 'DELETE'
        })
        this.students = this.students.filter(student => student.id !== id)
      } catch (error) {
        error;
      }
    },
  },
}
</script>

<style>
button {
  background: #009435;
  border: 1px solid #009435;
}
button:hover,
button:active,
button:focus {
  background: #32a95d;
  border: 1px solid #32a95d;
}
.small-container {
  max-width: 680px;
}
</style>
