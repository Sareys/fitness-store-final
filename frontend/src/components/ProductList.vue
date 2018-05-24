<template>
  <div class="product-list">
    <p v-if="loading">Loading....</p>
    <transition-group name="card" tag="ul" v-else>
      <li v-for="product in products" :key="product.id" class="product-card" :class="[ !productInStock(product) ? 'out-of-stock' : '' ]" tabindex="0" v-show="category === product.category || category === 'all'">
        <!--<router-link>-->
          <span class="sale-banner" v-if="product.sale">Sale</span>
          <span class="out-of-stock-banner" v-show="!productInStock(product)">Out of Stock</span>
          <img :src="`./static/images/${product.img}`" :alt="`image of ${product.title}`">
          <span class="product-title">{{product.title}}</span>
          <span class="product-price"> {{product.price | currency}}</span>
          <button @click="addProductToCart(product)" class="add-to-cart-btn">Add to cart</button>
        <!--</router-link>-->
      </li>
    </transition-group>
  </div>
</template>

<script>
  import {mapState, mapGetters, mapActions} from 'vuex'
  export default {
    name: 'ProductList',
    data() {
      return {
        // products: []
        loading: false,
        highprice: 100
      };
    },
    props: {
      category: {
        type: String,
        default: false
      },
    },
    computed : {
      // ...mapState({
      //   products: state => state.products
      // }),
      products() {
        return this.$store.state.products.filter(el =>
          this.$store.state.sale
            ? el.price < this.$store.state.highprice && el.sale
            : el.price < this.$store.state.highprice
        )
      },
      ...mapGetters({
        productInStock: 'productInStock'
      })
    },
    // computed: {
    //   products() {
    //     return this.$store.state.products
    //     // return this.$store.getters.availableProducts
    //   },
    //   productInStock() {
    //     return this.$store.getters.productInStock
    //   }
    // },
    created() {
      this.data.products = {
        id: 1,
        title: 'Faux Strelitzia Leaf Pair',
        price: 100.00,
        category: 'womenapparel',
        sale: false,
        img: 'planter1.jpg',
        inventory: 2
      },
        {
          id: 2,
          title: 'Rohini Daybed',
          price: 1119.99,
          category: 'menapparel',
          sale: false,
          img: 'daybed1.jpg',
          inventory: 20
        },
        {
          id: 3,
          title: 'Marte Basket Table',
          price: 179.99,
          category: 'furniture',
          sale: true,
          img: 'basket-table.jpg',
          inventory: 20
        },
        {
          id: 4,
          title: 'Modular Velvet Sofa',
          price: 549.00,
          category: 'furniture',
          sale: true,
          img: 'sofa1.jpg',
          inventory: 20
        },
        {
          id: 5,
          title: 'Vinyl Record Storage Set',
          price: 29.99,
          category: 'furniture',
          sale: false,
          img: 'rack.jpg',
          inventory: 5
        },
        {
          id: 6,
          title: '10" Marble Planter',
          price: 58.99,
          category: 'womenapparel',
          sale: true,
          img: 'planter2.jpg',
          inventory: 20
        },
        {
          id: 7,
          title: 'Desert Moonflower Credenza',
          price: 998.00,
          category: 'menapparel',
          sale: false,
          img: 'credenza.jpg',
          inventory: 20
        },
        {
          id: 8,
          title: 'Leni Leaning Mirror',
          price: 139.90,
          category: 'womenapparel',
          sale: false,
          img: 'mirror1.jpg',
          inventory: 0
        },
        {
          id: 9,
          title: 'Claudio Dining Set',
          price: 899.00,
          category: 'menapparel',
          sale: true,
          img: 'dining.jpg',
          inventory: 20
        },
        {
          id: 10,
          title: 'Symbology Banner',
          price: 129.99,
          category: 'womenapparel',
          sale: false,
          img: 'bunting.jpg',
          inventory: 20
        },
        {
          id: 11,
          title: 'Reema Sofa Set',
          price: 80.99,
          category: 'supplement',
          sale: false,
          img: 'sofa2.jpg',
          inventory: 20
        },
        {
          id: 12,
          title: 'Blush Velvet Daybed',
          price: 1179.89,
          category: 'supplement',
          sale: true,
          img: 'daybed2.jpg',
          inventory: 20
        },
        {
          id: 13,
          title: 'Polka Dot Wicker Basket',
          price: 69.00,
          category: 'supplement',
          sale: false,
          img: 'wicker.jpg',
          inventory: 20
        },
        {
          id: 14,
          title: 'Stripe Rag Rug',
          price: 29.99,
          category: 'accessories',
          sale: true,
          img: 'rag.jpg',
          inventory: 20
        },
        {
          id: 15,
          title: 'Rosalie Velvet Bed',
          price: 1820.90,
          category: 'accessories',
          sale: false,
          img: 'bed.jpg',
          inventory: 20
        },
        {
          id: 16,
          title: 'Wire Loop Vanity',
          price: 159.00,
          category: 'accessories',
          sale: true,
          img: 'vanity.jpg',
          inventory: 20
        }
      this.loading = true
      // this.$store.dispatch('fetchProducts')
      this.fetchProducts()
        .then(() => this.loading = false)
    },
    methods : {
      ...mapActions({
        fetchProducts: 'fetchProducts',
        addProductToCart: 'addProductToCart'
      }),
      // addProductToCart(product) {
      //   this.$store.dispatch('addProductToCart',product)
      // }
    }
  }
</script>

<style lang="css">
  .sale-banner {
    background: rgb(232, 35, 25);
    color: white;
    font-family: sans-serif;
    position: absolute;
    padding: 2px 10px 4px;
    text-transform: uppercase;
    font-size: 13px;
    font-weight: 700;
  }
  .out-of-stock-banner {
    background: #505050;
    color: #f9f9f9;
    font-family: sans-serif;
    position: absolute;
    padding: 2px 10px 4px;
    text-transform: uppercase;
    font-size: 13px;
    font-weight: 700;
    z-index: 99;
  }
  .add-to-cart-btn {
    opacity: 0;
  }
  @media (max-width: 600px) {
    .add-to-cart-btn {
      opacity: 1;
    }
  }
  .product-card:hover, .product-card:focus  {
    box-shadow: 1px 0rem 14px 0px #eee;
    outline: none;
  }
  .product-card:hover .add-to-cart-btn{
    opacity: 1;
  }
  /* For keyboard controls */
  .product-card:focus .add-to-cart-btn {
    opacity: 1;
  }
  .add-to-cart-btn:focus {
    opacity: 1;
  }
  .product-title {
    margin-top: 10px;
    margin-bottom: 5px;
  }
  .product-price {
    font-weight: bold;
  }
  .product-card.out-of-stock {
    pointer-events: none;
  }
  .product-card.out-of-stock button {
    display: none;
  }
  .product-card.out-of-stock img {
    opacity: 0.6;
  }
  .product-card.out-of-stock .product-price,  .product-card.out-of-stock .product-title{
    opacity: 0.6;
  }
</style>
