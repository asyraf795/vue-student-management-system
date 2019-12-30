<template>
  <div id="student-table">
    <p
      v-if="students.length < 1"
      class="empty-table"
    >
      No students
    </p>
    <table v-else>
      <thead>
        <tr>
          <th>Student Id</th>
          <th>ic</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Date of Birth</th>
          <th>Gender</th>
          <th>Email</th>
          <th>Phone No.</th>
          <th>Address</th>
          <th>PostCode</th>
          <th>State</th>
          <th>Country</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr
          :key="student.id"
          v-for="student in students"
        >
          <td>{{student.id}}</td>
          <td>{{student.ic}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.firstName"
            >
          </td>
          <td v-else>{{student.firstName}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.lastName"
            >
          </td>
          <td v-else>{{student.lastName}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.dateOfBirth"
            >
          </td>
          <td v-else>{{student.dateOfBirth}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.gender"
            >
          </td>
          <td v-else>{{student.gender}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.email"
            >
          </td>
          <td v-else>{{student.email}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.phoneNumber"
            >
          </td>
          <td v-else>{{student.phoneNumber}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.address"
            >
          </td>
          <td v-else>{{student.address}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.postcode"
            >
          </td>
          <td v-else>{{student.postcode}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.state"
            >
          </td>
          <td v-else>{{student.state}}</td>
          <td v-if="editing === student.id">
            <input
              type="text"
              v-model="student.country"
            >
          </td>
          <td v-else>{{student.country}}</td>                           
          <td v-if="editing === student.id">
            <button @click="editStudent(student)">Save</button>
            <button
              class="muted-button"
              @click="cancelEdit(student)"
            >Cancel</button>
          </td>
          <td v-else>
            <button @click="editMode(student)">Edit</button>
            <button @click="$emit('delete:student', student.id)">Delete</button>
          </td>

        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'student-table',
  props: {
    students: Array,
  },
  data() {
    return {
      editing: null,
    }
  },
  methods: {
    editMode(student) {
      this.cachedStudent = Object.assign({}, student)
      this.editing = student.id
    },
    cancelEdit(student) {
      Object.assign(student, this.cachedStudent)
      this.editing = null;
    },
    editStudent(student) {
      if (student.name === '' || student.email === '') return
      this.$emit('edit:student', student.id, student)
      this.editing = null
    }
  }
}
</script>