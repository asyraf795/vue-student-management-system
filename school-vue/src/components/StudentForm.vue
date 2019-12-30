<template>
  <div id="student-form">
    <form @submit.prevent="handleSubmit">

      <label>Student IC</label>
      <input
        ref="first"
        type="text"
        :class="{ 'has-error': submitting && invalidIC }"
        v-model="student.ic"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
      <label>First Name</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidFirstName }"
        v-model="student.firstName"
        @focus="clearStatus"
      >
      <label>Last Name</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidLastName }"
        v-model="student.lastName"
        @focus="clearStatus"
      >
      <label>Date of Birth</label>
      <input
        type="date"
        :class="{ 'has-error': submitting && invalidDateOfBirth }"
        v-model="student.dateOfBirth"
        @focus="clearStatus"
      >
      <label>Gender</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidGender }"
        v-model="student.gender"
        @focus="clearStatus"
      >
      <label>Email</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidEmail }"
        v-model="student.email"
        @focus="clearStatus"
      >
      <label>Phone Number</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidPhoneNumber }"
        v-model="student.phoneNumber"
        @focus="clearStatus"
      >
      <label>Address</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidAddress }"
        v-model="student.address"
        @focus="clearStatus"
      >
      <label>Postcode</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidPostcode }"
        v-model="student.postcode"
        @focus="clearStatus"
      >
      <label>State</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidState }"
        v-model="student.state"
        @focus="clearStatus"
      >
      <label>Country</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidCountry }"
        v-model="student.country"
        @focus="clearStatus"
      >
      <p
        v-if="error && submitting"
        class="error-message"
      >❗Please fill out all required fields</p>
      <p
        v-if="success"
        class="success-message"
      >✅ Student successfully added</p>
      <button>Add Student</button>
    </form>

  </div>
</template>

<script>
export default {
  name: 'student-form',
  data() {
    return {
      error: false,
      submitting: false,
      success: false,
      student: {
        ic: '',
        firstName: '',
        lastName: '',
        dateOfBirth: null,
        gender: '',
        email: '',
        phoneNumber: '',
        address: '',
        postcode: '',
        state: '',
        country: '',
      }
    }
  },
  computed: {
    invalidIC() {
      return this.student.ic === ''
    },
    invalidFirstName() {
      return this.student.firstName === ''
    },
    invalidLastName() {
      return this.student.lastName === ''
    },
    invalidDateOfBirth() {
      return this.student.dateOfBirth === null
    },
    invalidGender() {
      return this.student.gender === ''
    },
    invalidEmail() {
      return this.student.email === ''
    },
    invalidPhoneNumber() {
      return this.student.phoneNumber === ''
    },
    invalidAddress() {
      return this.student.address === ''
    },
    invalidPostcode() {
      return this.student.postcode === ''
    },
    invalidState() {
      return this.student.state === ''
    },
    invalidCountry() {
      return this.student.country === ''
    },
  },
  methods: {
    handleSubmit() {
      this.clearStatus()
      this.submitting = true
      if (this.invalidIC || this.invalidFirstName || this.invalidLastName || this.invalidDateOfBirth || this.invalidGender || this.invalidEmail || this.invalidPhoneNumber || this.invalidAddress || this.invalidPostcode || this.invalidState || this.invalidCountry) {
        this.error = true
        return
      }
      this.$emit('add:student', this.student)
      this.$refs.first.focus()
      this.student = {
        ic: '',
        firstName: '',
        lastName: '',
        dateOfBirth: null,
        gender: '',
        email: '',
        phoneNumber: '',
        address: '',
        postcode: '',
        state: '',
        country: '',
      }
      this.success = true
      this.error = false
      this.submitting = false
    },
    clearStatus() {
      this.success = false
      this.error = false
    }
  }}
</script>

<style scoped>
form {
  margin-bottom: 2rem;
}
[class*="-message"] {
  font-weight: 500;
}
.error-message {
  color: #d33c40;
}
.success-message {
  color: #32a95d;
}
</style>
