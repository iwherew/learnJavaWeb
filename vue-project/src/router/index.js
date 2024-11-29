import Vue from 'vue'
import VueRouter from 'vue-router'
import EmpView from "@/views/tlias/EmpView.vue";
import DeptView from "@/views/tlias/DeptView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/emp',
    name: 'emp',
    component: EmpView
  },
  {
    path: '/dept',
    name: 'dept',
    component: DeptView
  },
  {
    path: '/',
    redirect: '/emp',
  },
]

const router = new VueRouter({
  routes
})

export default router
