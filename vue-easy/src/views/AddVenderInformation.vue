<script setup>
import { ref, onMounted, watch } from "vue";
import Swal from 'sweetalert2/dist/sweetalert2.js'
import { useRouter } from 'vue-router'
import axios from "axios";
import VenderInfo from "@/models/VenderInfo.js"

const router = useRouter();
const venderInfo = ref(VenderInfo);
const old = ref(true)
const buttonValue = ref("送出")
const oldvalue = async () => {
    const URL = `${import.meta.env.VITE_API_easystep}/vender/findinformation`
    const response = await axios.get(URL, { withCredentials: true })
    if (response.data != 'N') {
        venderInfo.value = response.data
        buttonValue.value = "更新"
    }

}



// 確認是否為登入狀態
const logincheck = async () => {
    const URL = `${import.meta.env.VITE_API_easystep}/vender/checklogin`
    const response = await axios.get(URL, { withCredentials: true })
    if (response.data.success) {
    } else {
        await Swal.fire('請先登入')
        await router.push("/Vender/VenderLog")
        old.value = false
    }
}
// 送出
const sendto = async () => {
    await logincheck()
    const URL = `${import.meta.env.VITE_API_easystep}/vender/addinformation`
    const response = await axios.post(URL, venderInfo.value, { withCredentials: true })
    if (response.data == 'Y') {
        await Swal.fire('新增成功')
        await router.push("/")
    }
}

// 新增照片
const fileInput = ref(null);
const formData = ref([]);
const handleFileChange = (event) => {
    fileInput.value = event.target.files
    formData.value = new FormData();
    console.log(fileInput.value[0]);
    for (let i = 0; i < fileInput.value.length; i++) {
        formData.value.append("files", fileInput.value[i]);
    }
};
// 照片送到後端
const sendToServer = async () => {
    const API = `${import.meta.env.VITE_API_easystep}/1234`
    const response = await axios.post(API, formData.value, {
        withCredentials: true,
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    })
    if (response.data == 'y') {
        Swal.fire('上傳成功')
    }
};
const submitData = () => {
    venderInfo.value = {
        venderWorkmonth: '六七月',
        venderIntroduce: '埔心牧場除從事乳牛專業飼養外，並致力花卉栽培，各式奇花異草呈現一片花團錦簇，露天販賣店設置花木間，別有一番風情，牧場內新設的體能訓練場，20幾項野外健身活動設施，項項精彩刺激。露營、烤肉區，場地寬闊，水電設施供應十分完備。而且還有許多休閒遊樂系列，如射箭場、迷你馬場、協力車、環場馬車、游泳池等，來到桃園這裡絕對是你的不二地點。',
        venderStay: '三人房 雙人床與單人床 附WiFi 陽台 洗衣機',
        workMans: '3人',
        venderWorktime: '每日工作4小時'
    }
}
onMounted(async () => {
    await logincheck()
    venderInfo.value = ref(VenderInfo);
    if (old.value) {
        oldvalue()
    }
})
</script>
<template>
    <div>
        <form class="was-validated" @submit.prevent="sendToServer">
            <div class="card">
                <div class="card-header"><span>環境圖片</span></div>
                <div class="card-body">
                    <div class="mb-3">
                        <input type="file" class="form-control" aria-label="file example" required multiple
                            @change="handleFileChange">
                        <div class="invalid-feedback">若要多張 請按住 CTRL 選取多張圖片</div>
                    </div><button class="btn btn-outline-primary" type="submit">送出</button>
                </div>
            </div>
        </form>
        <form @submit.prevent="sendto">
            <div class="card">
                <div class="card-header"><span>可以上班的月份</span></div>
                <div class="card-body">
                    <div class="form-floating">
                        <textarea class="form-control" v-model="venderInfo.venderWorkmonth" required></textarea>
                    </div>
                </div>
                <div class="card-header"><span>簡單敘述</span></div>
                <div class="card-body">
                    <div class="form-floating">
                        <textarea class="form-control" v-model="venderInfo.venderIntroduce" required></textarea>
                    </div>
                </div>
                <div class="card-header"><span>供宿環境簡介</span></div>
                <div class="card-body">
                    <div class="form-floating">
                        <textarea class="form-control" v-model="venderInfo.venderStay" required></textarea>
                    </div>
                </div>
                <div class="card-header"><span>需求人數</span></div>
                <div class="card-body">
                    <div class="form-floating">
                        <textarea class="form-control" v-model="venderInfo.workMans" required></textarea>
                    </div>
                </div>
                <div class="card-header"><span>每日要求時數</span></div>
                <div class="card-body">
                    <div class="form-floating">
                        <textarea class="form-control" v-model="venderInfo.venderWorktime" required></textarea>
                    </div>
                </div>
            </div>
            <br>
            <button class="btn btn-outline-primary" type="submit">{{ buttonValue }}
            </button>
            <button type="button" class="btn btn-outline-light" @click="submitData">Demo</button>
        </form>
    </div>
</template>
<style scoped></style>
